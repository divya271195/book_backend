package com.jwt.jwtauth.model.hibernate;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserType implements UserType {

	@Override
	public int[] sqlTypes() {
		return new int[] {Types.JAVA_OBJECT};
	}

	@Override
	public Class<?> returnedClass() {
		return null;
	}

	public Type returnedType() {
		return null;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.nullSafeEquals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		if (x == null) {
			return 0;
		}

		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		Gson gson = getGson();

		PGobject o = (PGobject) rs.getObject(names[0]);
		if (o != null && o.getValue() != null) {
			try {
				if (returnedType() != null) {
					return gson.fromJson(o.getValue(), returnedType());
				}
				return gson.fromJson(o.getValue(), returnedClass());
			} catch (Exception e) {
				log.error("unable to deserialize value {}", o.getValue(), e);
			}
		}

		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		Gson gson = getGson();
		if (value == null) {
			st.setNull(index, Types.OTHER);
		} else {
			st.setObject(index, gson.toJson(value, returnedClass()), Types.OTHER);
		}
	}

	public Gson getGson() {
		Gson gson = new Gson();
		return gson;
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		Gson gson = getGson();
		if (returnedType() != null) {
			return gson.fromJson(gson.toJson(value), returnedType());
		}
		return gson.fromJson(gson.toJson(value), returnedClass());
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		Object copy = deepCopy(value);

		if (copy instanceof Serializable) {
			return (Serializable) copy;
		}
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return deepCopy(cached);
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return deepCopy(original);
	}

}
