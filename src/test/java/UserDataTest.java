import endpoints.Endpoints;
import helpers.requests.Requests;
import helpers.specifications.Specifications;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.RootWithListInData;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDataTest {
    String baseUri = Endpoints.BASE_URI;

    @DisplayName("Получение первой страницы из списка всех пользователей")
    @Test
    void getUserList() {
        //given
        RequestSpecification requestSpecification = Specifications.requestSpecificationNoBody(baseUri);
        ResponseSpecification responseSpecification = Specifications.responseSpecification(200);

        String pathToResource = Endpoints.USERS + "?page=1";

        //when
        RootWithListInData actualUserList = Requests.get(requestSpecification, pathToResource,
                responseSpecification, RootWithListInData.class);

        //then
        assertThat(actualUserList.getPage(), equalTo(1));
    }
}
