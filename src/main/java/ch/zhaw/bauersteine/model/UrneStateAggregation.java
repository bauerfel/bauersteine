package ch.zhaw.bauersteine.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class UrneStateAggregation {

    private String id;
    private List<String> urneIds;
    private String count;
}
