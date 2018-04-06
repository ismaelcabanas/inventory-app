package cabanas.garcia.ismael.inventory.stubs;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.ProductStockItem;
import cabanas.garcia.ismael.inventory.domain.storeroom.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.StoreroomRepository;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertThat(argCaptorStoreroom.getValue().stockOf(productId)).isEqualTo(stock);
        assertThat(argCaptorStoreroom.getValue().id()).isEqualTo(storeroomId);
    }

    public void verifyProductStockWasSavedInStoreroom(Storeroom theStoreroom, ProductId productId, Stock stock) {
        ArgumentCaptor<ProductStockItem> argCaptorProductStock = ArgumentCaptor.forClass(ProductStockItem.class);
        verify(storeroomRepositoryMock, times(1)).saveProductStock(argCaptorProductStock.capture());

        assertThat(argCaptorProductStock.getValue().productId()).isEqualTo(productId);
        assertThat(argCaptorProductStock.getValue().stock()).isEqualTo(stock);
        assertThat(argCaptorProductStock.getValue().storeroomId()).isEqualTo(theStoreroom.id());
    }

    public void verifyStoreroomIsSaved(Storeroom theStoreroom) {
        verify(storeroomRepositoryMock, times(1)).create(theStoreroom);
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
    public void saveProductStock(ProductStockItem productStockItem) {
        storeroomRepositoryMock.saveProductStock(productStockItem);
    }

    @Override
    public void create(Storeroom theStoreroom) {
        storeroomRepositoryMock.create(theStoreroom);
    }
}
