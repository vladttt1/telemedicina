package PatientAccount;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository  extends MongoRepository<Integer,Integer> {
}
