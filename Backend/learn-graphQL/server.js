import { buildSchema } from 'graphql';
import { createHandler } from 'graphql-http/lib/use/express';
import { ruruHTML } from 'ruru/server';
import express from 'express';
 
// Construct a schema, using GraphQL schema language
const books = [
  {
    id: 'book-1',
    name: 'Effective Java',
    pageCount: 416,
    author: 'author-1'
  },
  {
    id: 'book-2',
    name: "Hitchhiker's Guide to the Galaxy",
    pageCount: 208,
    author: 'author-2'
  },
  {
    id: 'book-3',
    name: 'Down Under',
    pageCount: 436,
    author: 'author-3'
  }
];

const authors = [
  {
    id: 'author-1',
    firstName: 'Joshua',
    lastName: 'Bloch'
  },
  {
    id: 'author-2',
    firstName: 'Douglas',
    lastName: 'Adams'
  },
  {
    id: 'author-3',
    firstName: 'Bill',
    lastName: 'Bryson'
  }
];


const schema = buildSchema(`
  type Query {
      bookById(id: ID): Book
      allBooks: [Book]
      allAuthors: [Author]
  }

  type Book {
      id: ID
      name: String
      pageCount: Int
      author: Author
  }

  type Author {
      id: ID
      firstName: String
      lastName: String
  }
`);
 
// The root provides a resolver function for each API endpoint
const root = {
  bookById({ id }) {
    const book = books.find(b => b.id === id);
    if (!book) return null;

    const author = authors.find(a => a.id === book.author);
    return {
      ...book,
      author,
    };
  },
  allBooks(){
    const booksList = books.map(book => {
      const author = authors.find(a => a.id === book.author);
      return {
        ...book,
        author
      }
    })
    return booksList
  },
  allAuthors(){
    return authors
  }
};
 
const app = express();
 
// Create and use the GraphQL handler.
app.all(
  '/graphql',
  createHandler({
    schema: schema,
    rootValue: root,
  }),
);
 
// Start the server at port
app.get('/', (_req, res) => {
  res.type('html');
  res.end(ruruHTML({ endpoint: '/graphql' }));
});

app.listen(4000);
console.log('Running a GraphQL API server at http://localhost:4000/graphql');
