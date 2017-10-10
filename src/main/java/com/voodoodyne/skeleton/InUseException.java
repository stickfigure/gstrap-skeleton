/*
 */

package com.voodoodyne.skeleton;

import com.voodoodyne.gstrap.rest.ClientException;

/**
 * Indicates that the thing you tried to delete was still in use
 */
public class InUseException extends ClientException
{
	private static final long serialVersionUID = -5807425036110725466L;

	public InUseException(final String message) {
		super(message);
	}
}
