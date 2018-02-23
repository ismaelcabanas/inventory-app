package cabanas.garcia.ismael.inventory.application.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.stubs.StoreroomSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class RegisterStoreroomServiceShould {

    private static final String SOME_STOREROOM_NAME = "STORE TEST";

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private StoreroomRepository storeroomRepository;

    private StoreroomSuccessRepositoryStub storeroomSuccessRepositoryStub;

    @Test public void
    register_a_new_storeroom() {
        Storeroom storeroom = new Storeroom(SOME_STOREROOM_NAME);
        storeroomSuccessRepositoryStub = new StoreroomSuccessRepositoryStub(storeroomRepository, storeroom);
        RegisterStoreroomService registerStoreroomService = new RegisterStoreroomService(storeroomSuccessRepositoryStub);

        registerStoreroomService.register(storeroom);

        verifyStoreroomIsSaved(storeroom);
    }

    private void verifyStoreroomIsSaved(Storeroom storeroom) {
        storeroomSuccessRepositoryStub.verifyStoreroomIsSaved(storeroom);
    }
}
