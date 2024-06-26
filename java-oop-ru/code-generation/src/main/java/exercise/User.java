package exercise;

import lombok.Value;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
