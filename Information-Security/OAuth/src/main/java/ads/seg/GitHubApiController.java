package ads.seg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GitHubApiController {
    // Injeção de dependência do WebClient.Builder
    @Autowired
    private WebClient.Builder webClientBuilder;
    /**
     * Método que retorna a página 'repositorios.html' com a lista de repositórios do usuário
     autenticado.
     * @param model Objeto Model para adicionar atributos à página HTML
     * @param authorizedClient Objeto OAuth2AuthorizedClient com as informações do cliente
    autorizado
     * @return String com o nome da página HTML a ser exibida na aplicação web
     */
    @GetMapping("/repos")
    public String getRepos(Model model, @RegisteredOAuth2AuthorizedClient("github")
    OAuth2AuthorizedClient authorizedClient) {
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
// Chamada à API do GitHub para obter os repositórios
        List<Object> repos = webClientBuilder.build()
                .get()
                .uri("https://api.github.com/user/repos")
                .headers(headers -> headers.setBearerAuth(accessToken.getTokenValue()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Object>>() {})
                .block();
// Adiciona a lista de repositórios ao modelo
        model.addAttribute("repos", repos);
        return "repositorios"; // Retorna a página 'repositorios.html'
    }

    @GetMapping("/criar-repo")
    public String getCriarRepo(Model model, @RegisteredOAuth2AuthorizedClient("github")
    OAuth2AuthorizedClient authorizedClient){
        model.addAttribute("formulario", new Formulario());
        return "criar-repositorio";
    }

    @PostMapping("/criar-repo")
    public String criarRepo(@ModelAttribute Formulario form, Model model, @RegisteredOAuth2AuthorizedClient("github")
    OAuth2AuthorizedClient authorizedClient){
        model.addAttribute("formulario", form);
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("name", form.getname());
        bodyMap.put("description", form.getdescription());
        System.out.println("======================================================");
        System.out.println("AQUI==================");
        System.out.println("======================================================");
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        webClientBuilder.build()
                .post()
                .uri("https://api.github.com/user/kauanrfontana/repos")
                .headers(headers -> headers.setBearerAuth(accessToken.getTokenValue()))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(form)
                .retrieve()
                .bodyToMono(Void.class);

        return "resultado";

    }
}
