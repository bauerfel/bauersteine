package ch.zhaw.bauersteine.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Getter
//@RequiredArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    @Id
    private String id;

    @NonNull
    private List<String> urneIds; // ID der Urne
    
    private OrderState state = OrderState.ASSIGNED;// Status der Bestellung

    @NonNull
    private String userEmail;

    public void setState(OrderState state) {
        this.state = state;
    }

    public Order(List<String> urneIds, String userEmail) {
        this.urneIds = urneIds;
        this.userEmail = userEmail;
    }

}
