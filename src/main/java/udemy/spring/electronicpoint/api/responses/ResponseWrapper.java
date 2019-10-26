package udemy.spring.electronicpoint.api.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {

    private T data;

    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
