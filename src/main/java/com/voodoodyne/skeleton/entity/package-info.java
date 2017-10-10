/**
 */
@TypeDefs({
		@TypeDef(name="tags", typeClass=TreeSetStringUserType.class),
})
package com.voodoodyne.skeleton.entity;

import com.voodoodyne.postguice.usertype.TreeSetStringUserType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;