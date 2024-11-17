package task_16;

import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.Properties;

class TrelloApiBO {

    static Properties prop = new Properties();

    static {
        try {
            String filePath = Paths.get("src", "main", "resources", "property.config").toAbsolutePath().toString();
            prop.load(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    static String key = prop.getProperty("Trello_APІ_KEY");
    static String token = prop.getProperty("Trello_Token");

    public HttpResponse<String> createOrganization(String displayName) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations?displayName=" + displayName + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public HttpResponse<String> createBoard(String name) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards?name=" + name + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public HttpResponse<String> createList(String name, String boardId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists?name=" + name + "&idBoard=" + boardId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public HttpResponse<String> createCard(String name, String listId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards?name=" + name + "&idList=" + listId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public HttpResponse<String> addComment(String cardId, String text) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards/" + cardId + "/actions/comments?text=" + text + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public HttpResponse<String> deleteComment(String cardId, String commentId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards/" + cardId + "/actions/" + commentId + "/comments?key=" + key + "&token=" + token))
                .DELETE()
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }
}
