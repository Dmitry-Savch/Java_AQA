package task_16;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class  Task16Test {

    TrelloApiBO trelloApiBO = new TrelloApiBO();

    @Test
    void trelloApiTest() throws URISyntaxException, IOException, InterruptedException {
        // створення організації
        HttpResponse<String> createOrganizationResponse = trelloApiBO.createOrganization("TestOrganization");
        JsonNode organizationNode = new ObjectMapper().readTree(createOrganizationResponse.body());
        String organizationId = organizationNode.get("id").asText();

        // створення дошки
        HttpResponse<String> createBoardResponse = trelloApiBO.createBoard("TestBoard");
        JsonNode boardNode = new ObjectMapper().readTree(createBoardResponse.body());
        String boardId = boardNode.get("id").asText();

        // створення списку
        HttpResponse<String> createListResponse = trelloApiBO.createList("TestList", boardId);
        JsonNode listNode = new ObjectMapper().readTree(createListResponse.body());
        String listId = listNode.get("id").asText();

        // створення картки
        HttpResponse<String> createCardResponse = trelloApiBO.createCard("TestCard", listId);
        JsonNode cardNode = new ObjectMapper().readTree(createCardResponse.body());
        String cardId = cardNode.get("id").asText();

        // додавання коментаря
        HttpResponse<String> addCommentResponse = trelloApiBO.addComment(cardId, "This is a test comment");
        JsonNode commentNode = new ObjectMapper().readTree(addCommentResponse.body());
        String commentId = commentNode.get("id").asText();

        // видалення коментаря
        trelloApiBO.deleteComment(cardId, commentId);

        // додавання нового коментаря
        trelloApiBO.addComment(cardId, "Updated comment text");
    }
}
