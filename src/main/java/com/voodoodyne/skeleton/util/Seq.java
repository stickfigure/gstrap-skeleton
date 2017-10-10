package com.voodoodyne.skeleton.util;

import com.voodoodyne.postguice.Sequence;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Efficiently fetch sequence values.
 * Don't forget to requestStaticInjection for this class.
 */
@Singleton
public class Seq extends Sequence {

	@Inject
	private static Seq instance;

	/** The business end of this object */
	public static long nextId() {
		return instance.next();
	}

	public Seq() {
		super("seq", 10);
	}
}
