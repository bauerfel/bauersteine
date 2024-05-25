package ch.zhaw.bauersteine.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UrneStateAggregation {

    private String id;
    private List<String> urneIds;
    private String count;
}
