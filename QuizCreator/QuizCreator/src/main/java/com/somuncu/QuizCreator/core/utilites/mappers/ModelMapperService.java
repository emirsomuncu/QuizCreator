package com.somuncu.QuizCreator.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	public ModelMapper forResponse();
	public ModelMapper forRequest();
}
