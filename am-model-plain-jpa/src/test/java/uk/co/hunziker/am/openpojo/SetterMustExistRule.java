package uk.co.hunziker.am.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;

public class SetterMustExistRule implements Rule {

	@Override
	public void evaluate(PojoClass pojoClass) {
		for (PojoField fieldEntry : pojoClass.getPojoFields()) {
			if (!fieldEntry.isFinal() && !fieldEntry.getName().startsWith("_") && !fieldEntry.hasSetter()) {
				Affirm.fail(String.format("[%s] is missing a setter", fieldEntry));
			}
		}
	}

}
