package com.jwt.jwtauth.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter

public abstract class SuperBaseModel<U extends SuperBaseModel<U,V>, V> {

	
	protected V toDomain() { return null;}

	protected U from(V dataModel) { return null; }

	public static <T> List<T> toDomainList(List<? extends SuperBaseModel<?, T>> dbModelList) {
		List<T> output = new ArrayList<>();
		dbModelList.forEach(db -> output.add((T) db.toDomain()));
		return output;
	}

	public List<U> toDbList(List<? extends DataModel> dataModelList) {
		List<U> output = new ArrayList<>();
		dataModelList.forEach(dom -> output.add(from((V) dom)));
		return output;
	}
}
