package com.magabe.erp.security.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class AuditableTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#getCreatedBy()}
     *   <li>{@link Role#getCreatedBy()}
     * </ul>
     */
    @Test
    void testGetCreatedBy() {
        assertNull((new Role()).getCreatedBy());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#getCreatedDate()}
     *   <li>{@link Role#getCreatedDate()}
     * </ul>
     */
    @Test
    void testGetCreatedDate() {
        assertNull((new Role()).getCreatedDate());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#getLastModifiedBy()}
     *   <li>{@link Role#getLastModifiedBy()}
     * </ul>
     */
    @Test
    void testGetLastModifiedBy() {
        assertNull((new Role()).getLastModifiedBy());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#getLastModifiedDate()}
     *   <li>{@link Role#getLastModifiedDate()}
     * </ul>
     */
    @Test
    void testGetLastModifiedDate() {
        assertNull((new Role()).getLastModifiedDate());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#setCreatedBy(Object)}
     *   <li>{@link Role#setCreatedBy(Object)}
     * </ul>
     */
    @Test
    void testSetCreatedBy() {
        Role role = new Role();
        role.setCreatedBy("Created By");
        assertEquals("Created By", role.getCreatedBy());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#setCreatedDate(Date)}
     *   <li>{@link Role#setCreatedDate(Date)}
     * </ul>
     */
    @Test
    void testSetCreatedDate() {
        Role role = new Role();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        role.setCreatedDate(fromResult);
        assertSame(fromResult, role.getCreatedDate());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#setLastModifiedBy(Object)}
     *   <li>{@link Role#setLastModifiedBy(Object)}
     * </ul>
     */
    @Test
    void testSetLastModifiedBy() {
        Role role = new Role();
        role.setLastModifiedBy("Last Modified By");
        assertEquals("Last Modified By", role.getLastModifiedBy());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Auditable#setLastModifiedDate(Date)}
     *   <li>{@link Role#setLastModifiedDate(Date)}
     * </ul>
     */
    @Test
    void testSetLastModifiedDate() {
        Role role = new Role();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        role.setLastModifiedDate(fromResult);
        assertSame(fromResult, role.getLastModifiedDate());
    }
}

