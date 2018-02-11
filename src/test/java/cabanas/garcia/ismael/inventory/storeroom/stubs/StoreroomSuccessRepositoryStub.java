package cabanas.garcia.ismael.inventory.storeroom.stubs;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.Stock;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.Storeroom;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.StoreroomId;
import cabanas.garcia.ismael.inventory.storeroom.domain.repository.StoreroomRepository;
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class StoreroomSuccessRepositoryStub implements StoreroomRepository {
    private final StoreroomRepository storeroomRepositoryMock;
    private final Storeroom storeroom;

    public StoreroomSuccessRepositoryStub(StoreroomRepository storeroomRepositoryMock, Storeroom storeroom) {
        this.storeroomRepositoryMock = storeroomRepositoryMock;
        this.storeroom = storeroom;
    }

    public void verifySaveProductInStoreroomWithStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        ArgumentCaptor<Storeroom> argCaptorStoreroom = ArgumentCaptor.forClass(Storeroom.class);
        verify(storeroomRepositoryMock, times(1)).save(argCaptorStoreroom.capture());

        Assertions.assertThat(argCaptorStoreroom.getValue().stockOf(productId)).isEqualTo(stock);
    }

    @Override
    public Optional<Storeroom> findById(StoreroomId storeroomId) {
        return Optional.of(storeroom);
    }

    @Override
    public void save(Storeroom storeroom) {
        storeroomRepositoryMock.save(storeroom);
    }
}
