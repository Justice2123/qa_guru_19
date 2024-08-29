package data;


import config.web.AuthConfig;
import lombok.Data;
import models.AuthorizationBodyModel;
import org.aeonbits.owner.ConfigFactory;


@Data

public class DataTest {

    public String isbn = "9781593275846";
    private String userName = getAuthorizationBodyModel().getUserName();
    private String password = getAuthorizationBodyModel().getPassword();

    private AuthorizationBodyModel getAuthorizationBodyModel() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        return new AuthorizationBodyModel(config.userName(), config.password());
    }


}
