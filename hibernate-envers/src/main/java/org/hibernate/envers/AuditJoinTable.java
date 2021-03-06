/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, 2013, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.envers;

import javax.persistence.JoinColumn;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface AuditJoinTable {
	/**
	 * Name of the join table. Defaults to a concatenation of the names of the primary table of the entity
	 * owning the association and of the primary table of the entity referenced by the association.
	 */
	String name() default "";

	/**
	 * The schema of the join table. Defaults to the schema of the entity owning the association.
	 */
	String schema() default "";

	/**
	 * The catalog of the join table. Defaults to the catalog of the entity owning the association.
	 */
	String catalog() default "";

	/**
	 * The foreign key columns of the join table which reference the primary table of the entity that does not
	 * own the association (i.e. the inverse side of the association).
	 */
	JoinColumn[] inverseJoinColumns() default {};
}
