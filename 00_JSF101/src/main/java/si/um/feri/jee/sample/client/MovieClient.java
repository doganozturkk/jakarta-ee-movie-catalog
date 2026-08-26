package si.um.feri.jee.sample.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MovieClient {

    private static final String BASE_URL =
            "http://localhost:8080/my-jsf-sample-project/api/movies";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("🎬 ENTER MOVIE DETAILS");

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Genre: ");
        String genre = sc.nextLine();

        System.out.print("Release Year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Director (optional - press enter to skip): ");
        String director = sc.nextLine();

        // Dynamic JSON build
        String json = """
        {
          "title": "%s",
          "genre": "%s",
          "releaseYear": %d,
          "description": "%s",
          "director": "%s"
        }
        """.formatted(title, genre, year, description, director);

        System.out.println("\n Sending JSON:");
        System.out.println(json);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\n✅ Response:");
        System.out.println(response.body());

        sc.close();
    }
}