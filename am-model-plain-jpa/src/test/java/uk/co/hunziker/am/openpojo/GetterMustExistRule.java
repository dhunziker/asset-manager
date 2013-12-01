package uk.co.hunziker.am.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.utils.ValidationHelper;

public class GetterMustExistRule implements Rule {

	@Override
	public void evaluate(PojoClass pojoClass) {
		for (PojoField fieldEntry : pojoClass.getPojoFields()) {
			if (!ValidationHelper.isStaticFinal(fieldEntry) && !fieldEntry.getName().startsWith("_")
					&& !fieldEntry.hasGetter()) {
				Affirm.fail(String.format("[%s] is missing a getter", fieldEntry));
			}
		}
	}

}
