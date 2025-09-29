package kr.co.sboard.service;

import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.entity.Terms;
import kr.co.sboard.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TermsService {

    private final TermsRepository termsRepository;

    public TermsDTO getTerms(int no){

        Optional<Terms> optTerms = termsRepository.findById(no);

        if(optTerms.isPresent()){
            Terms terms = optTerms.get();
            return terms.toDTO();//약관이 있으면 나오고
        }
        return null;
    }
    public List<TermsDTO> getTermsAll(){
        return null;
    }
    public void save(TermsDTO termsDTO){}
    public void modify(TermsDTO termsDTO){}
    public void remove(int no){}

}
