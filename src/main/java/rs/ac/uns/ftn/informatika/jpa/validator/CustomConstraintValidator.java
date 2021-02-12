package rs.ac.uns.ftn.informatika.jpa.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomConstraintValidator implements ConstraintValidator<CustomAnnotation, Object> {

	@Override
	public void initialize(CustomAnnotation string) {

	}

	@Override
	public boolean isValid(Object customField, ConstraintValidatorContext ctx) {

		if (customField == null) {
			return false;
		}
		if(customField instanceof String)
			return customField.toString().trim()!="";
		return true;
	}

}
