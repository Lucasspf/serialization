package serialization.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExBooks {

        private static final String BOOKS_JSON = """
                {
                  "books": [
                    {
                      "isbn": "43243840983",
                      "title": "Java é demais!",
                      "author": "Zé Programador",
                      "num_pag": 354
                    },
                    {
                      "isbn": "9986748783",
                      "title": "Aprenda Java",
                      "author": "Pedro Paulo",
                      "num_pag": 545
                    },
                    {
                      "isbn": "587763767883",
                      "title": "Java Para Iniciantes",
                      "author": "Rodrigo Junqueira",
                      "num_pag": 530
                    }
                  ]
                }
                """;

        private static class Books{
            private  List<Book> books;

            public Books(){
            }

            public Books(List<Book> books) {
                this.books = books;
            }

            public List<Book> getBooks() {
                return books;
            }

            @Override
            public String toString() {
                return "Books{" +
                        "books=" + books +
                        '}';
            }
        }

        private static class Book{
            private  String isbn;
            private  String title;
            private  String author;

            @JsonProperty("num_pag")
            private  int numPag;

            public Book(){}


            public String getIsbn() {
                return isbn;
            }

            public String getTitle() {
                return title;
            }

            public String getOuthor() {
                return author;
            }

            public int getNumPag() {
                return numPag;
            }

            @Override
            public String toString() {
                return "Book{" +
                        "isbn='" + isbn + '\'' +
                        ", title='" + title + '\'' +
                        ", outhor='" + author + '\'' +
                        ", numPag=" + numPag +
                        '}';
            }
        }

    public static void main(String[] args) throws Exception{
       Books books = JsonUtils.mapper().readValue(BOOKS_JSON, Books.class);
        System.out.println(books);

        System.out.println(JsonUtils.mapper().writeValueAsString(books));

    }
}
