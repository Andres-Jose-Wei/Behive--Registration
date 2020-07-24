package com.weiwudev.services;

import com.weiwudev.models.User;
import com.weiwudev.models.UserAuth;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
public class RegistrationServiceImpl implements RegistrationService {

    @Value("${registration_service.authService_uri}")
    private String authServiceUri;

    @Autowired
    private MessageService messageService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Mono<String> registerUser(User user){

        UserAuth userAuth = new UserAuth();
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        userAuth.setUsername(user.getUsername());
        userAuth.setPassword(user.getPassword());
        userAuth.setRoles(roles);
        user.setPassword(null);

        return webClientBuilder.build().post().uri(authServiceUri)
                .bodyValue(userAuth)
                .retrieve()
                .bodyToMono(String.class).map(body -> {
                    user.setId(body);
                    messageService.sendUserData(user);
                    return "Account Created Successfully";
                });

    }

}
