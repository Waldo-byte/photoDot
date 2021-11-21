package logic.flow.Implementation;

import domain.dto.PhotoClassDTO;
import logic.flow.PhotoClassFlow;
import translator.PhotoClassTranslator;

public class PhotoClassFlowImpl implements PhotoClassFlow {
    private final PhotoClassTranslator photoClassTranslator;

    public PhotoClassFlowImpl(PhotoClassTranslator photoClassTranslator) {
        this.photoClassTranslator = photoClassTranslator;
    }

    @Override
    public PhotoClassDTO create(PhotoClassDTO photoClassDTO) {
        return photoClassTranslator.create(photoClassDTO);
    }
}
