# Comandos Docker
```bash
docker build -t servidor-web .
docker run servidor-web
docker run -p 8000:8000 servidor-web
docker run -p 8000:8000 -v $(pwd)/www:/www servidor-web
docker compose up
```
