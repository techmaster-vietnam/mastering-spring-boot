package vn.techmaster.login.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.techmaster.login.model.SaveUserModel;
import vn.techmaster.login.request.RegisterRequest;

@Component
@AllArgsConstructor
public class RequestToModelConverter {

    public SaveUserModel toModelSaveUserModel(
        RegisterRequest request
    ) {
        return SaveUserModel.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(request.getPassword())
            .displayName(request.getDisplayName())
            .build();
    }
}
