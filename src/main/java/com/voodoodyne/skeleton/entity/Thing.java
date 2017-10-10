/*
 */

package com.voodoodyne.skeleton.entity;

import com.voodoodyne.skeleton.util.Seq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A random entity
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = "id")
@ToString(doNotUseGetters = true)
@Slf4j
public class Thing
{
	/** */
	@Id
	@Getter
	@Column(name="thing_id")
	private Long id;

	/** */
	@Getter
	private Instant created;

	/** */
	@Getter @Setter
	private String name;

	/** */
	@Type(type="tags")
	@Getter @Setter
	private SortedSet<String> tags = new TreeSet<>();

	/**
	 */
	public Thing(final String name, final SortedSet<String> tags) {
		this.id = Seq.nextId();
		this.setName(name);
		this.tags = tags;

		this.created = Instant.now();
	}

	@Data
	public static class ThingData {
		private final long id;
		private final String name;
		private final SortedSet<String> tags;

		public ThingData(final Thing thing) {
			this.id = thing.getId();
			this.name = thing.getName();
			this.tags = thing.getTags();
		}
	}

	public ThingData data() {
		return new ThingData(this);
	}
}
