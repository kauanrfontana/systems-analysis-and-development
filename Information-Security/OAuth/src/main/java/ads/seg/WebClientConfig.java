package ads.seg;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {
    /**
     * Método que retorna um objeto WebClient.Builder para realizar chamadas à API do GitHub.
     */
    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
