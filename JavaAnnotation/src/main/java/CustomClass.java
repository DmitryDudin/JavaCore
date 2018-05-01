import lombok.AccessLevel;
import lombok.Getter;

import java.lang.annotation.Documented;

@Description(title = "customTitle", text = "customText", customClass = Object.class)
public class CustomClass {
    int id;
    String str;
}
