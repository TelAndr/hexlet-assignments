package exercise.dto;

// BEGIN
@Setter
@Getter
public class GuestCreateDTO {
    @NotNull
    private String name;
	
	@Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]{11,13}$")
	private String phoneNumber;

	@Pattern(regexp = "\\d{4}")
    private String clubCard;

	@FutureOrPresent
    private LocalDate cardValidUntil;
}
// END
