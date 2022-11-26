package DH.back_integrador.service;

import DH.back_integrador.model.Feature;
import DH.back_integrador.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature saveFeature(Feature feature){
        return featureRepository.save(feature);
    }

    public Feature getFeature(Long id){
        return featureRepository.findById(id).get();
    }

    public List<Feature> getAllFeature(){
        return featureRepository.findAll();
    }

    public void updateFeature(Long id, Feature feature){
        Feature featureOld = featureRepository.findById(id).get();

        featureOld.setName(feature.getName());
        featureOld.setReferenceIcon(feature.getReferenceIcon());

        featureRepository.save(featureOld);
    }

    public void deleteFeature(Long id){
        featureRepository.deleteById(id);
    }
}
