package logic.flow.Implementation;

import domain.dto.SharedImagesDTO;
import logic.flow.SharedImagesFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import translator.ShareImagesTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "translator")
public class ShareImagesFlowImpl implements SharedImagesFlow {
    private final ShareImagesTranslator shareImagesTranslator;

    @Autowired
    public ShareImagesFlowImpl(ShareImagesTranslator shareImagesTranslator) {
        this.shareImagesTranslator = shareImagesTranslator;
    }

    @Override
    public SharedImagesDTO create(SharedImagesDTO sharedImagesDTO) {
        return shareImagesTranslator.create(sharedImagesDTO);
    }
}
