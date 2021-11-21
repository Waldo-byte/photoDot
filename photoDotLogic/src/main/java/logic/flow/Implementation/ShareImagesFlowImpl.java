package logic.flow.Implementation;

import domain.dto.SharedImagesDTO;
import logic.flow.SharedImagesFlow;
import translator.ShareImagesTranslator;

public class ShareImagesFlowImpl implements SharedImagesFlow {
    private final ShareImagesTranslator shareImagesTranslator;

    public ShareImagesFlowImpl(ShareImagesTranslator shareImagesTranslator) {
        this.shareImagesTranslator = shareImagesTranslator;
    }

    @Override
    public SharedImagesDTO create(SharedImagesDTO sharedImagesDTO) {
        return shareImagesTranslator.create(sharedImagesDTO);
    }
}
