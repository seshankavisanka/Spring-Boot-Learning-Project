package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This tells Spring that this class is a Component of type RestController and
                // capable of handling HTTP requests
@RequestMapping("/cashcards") // This is a companion to @RestController that indicates which address requests
                              // must have to access this Controller
public class CashCardController {

  @GetMapping("/{requestedId}")
  public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
    if (requestedId.equals(99L)) {
      CashCard cashCard = new CashCard(99L, 123.45);
      return ResponseEntity.ok(cashCard);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
