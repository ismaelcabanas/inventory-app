package cabanas.garcia.ismael.inventory.stubs;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.*;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class StoreroomSuccessRepositoryStub implements StoreroomRepository {
    private final StoreroomRepository storeroomRepositoryMock;
    private final Storeroom storeroom;

    public StoreroomSuccessRepositoryStub(StoreroomRepository storeroomRepositoryMock, Storeroom theStoreroom) {
        this.storeroomRepositoryMock = storeroomRepositoryMock;
        this.storeroom = theStoreroom;
    }

    public void verifySaveProductInStoreroomWithStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        ArgumentCaptor<Storeroom> argCaptorStoreroom = ArgumentCaptor.forClass(Storeroom.class);
        verify(storeroomRepositoryMock, times(1)).save(argCaptorStoreroom.capture());

        Assertions.assertThat(argCaptorStoreroom.getValue().stockOf(productId)).isEqualTo(stock);
    }

    public void verifyProductStockWasSavedInStoreroom(Storeroom storeroom, ProductId productId, Stock stock) {
        ArgumentCaptor<ProductStock> argCaptorProductStock = ArgumentCaptor.forClass(ProductStock.class);
        verify(storeroomRepositoryMock, times(1)).saveProductStock(argCaptorProductStock.capture());

        Assertions.assertThat(argCaptorProductStock.getValue().product()).isEqualTo(productId);
        Assertions.assertThat(argCaptorProductStock.getValue().stock()).isEqualTo(stock);
        Assertions.assertThat(argCaptorProductStock.getValue().storeroom()).isEqualTo(storeroom);
    }

    @Override
    public Optional<Storeroom> findById(StoreroomId storeroomId) {
        return Optional.of(storeroom);
    }

    @Override
    public List<Storeroom> findAll() {
        return Arrays.asList(storeroom);
    }

    @Override
    public void save(Storeroom storeroomToSave) {
        storeroomRepositoryMock.save(storeroomToSave);
    }

    @Override
    public void saveProductStock(ProductStock productStock) {
        storeroomRepositoryMock.saveProductStock(productStock);
    }


}
