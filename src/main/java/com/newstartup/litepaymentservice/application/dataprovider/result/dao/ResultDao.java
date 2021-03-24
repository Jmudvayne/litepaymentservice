package com.newstartup.litepaymentservice.application.dataprovider.result.dao;

import com.newstartup.litepaymentservice.application.dataprovider.result.model.ResultDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultDao extends MongoRepository <ResultDocument, String> {
}
