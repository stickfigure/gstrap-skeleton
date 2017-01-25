/*
 */

package com.voodoodyne.skeleton.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.voodoodyne.gstrap.util.json.Jsogify;
import com.voodoodyne.gstrap.util.json.JsonAutoDetectOff;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.util.SortedSet;
import java.util.TreeSet;

import static com.googlecode.objectify.ObjectifyService.factory;
import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * A random entity
 */
@Entity
@Cache(expirationSeconds = 3600)
@JsonAutoDetectOff
@Jsogify
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = "id")
@ToString(doNotUseGetters = true)
@Slf4j
public class Thing
{
	/** */
	@Id
	private Long id;

	/** */
	@JsonProperty
	@Getter @Setter
	private String name;

	/** */
	@Index
	@Getter
	private DateTime created;

	/** */
	@JsonProperty
	@Getter
	private SortedSet<String> tags = new TreeSet<>();

	/**
	 */
	public Thing(String name) {
		this.id = factory().allocateId(Thing.class).getId();
		this.setName(name);

		this.created = new DateTime();

		ofy().defer().save().entity(this);
	}
}
