package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuiteResponse {
    boolean status;
    Result result;
}
