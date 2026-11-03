package id.ac.polban.pbo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount savings;

    @BeforeEach
    void setUp() {
        savings = new SavingsAccount("003", "Citra", 100_000, 0.05);
    }

    @Test
    void savingsAccount_adalahBankAccount() {
        assertInstanceOf(BankAccount.class, savings);
    }

    @Test
    void withdraw_melanggarSaldoMinimum_ditolak() {
        BankAccount acc = savings; // tipe deklarasi: induk
        assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(60_000));
        assertEquals(100_000, acc.getBalance(), 0.001);
    }

    @Test
    void withdraw_tepatDiBatasMinimum_diterima() throws InsufficientBalanceException {
        savings.withdraw(50_000);
        assertEquals(SavingsAccount.MIN_BALANCE, savings.getBalance(), 0.001);
    }

    @Test
    void transfer_memakaiAturanWithdrawKelasAnak() {
        BankAccount target = new BankAccount("004", "Dodi", 0);
        assertThrows(InsufficientBalanceException.class,
            () -> savings.transfer(target, 70_000));
    }

    @Test
    void addInterest_menambahBungaLimaPersen() {
        savings.addInterest();
        assertEquals(105_000, savings.getBalance(), 0.001);
    }

    // ---- Latihan 3 ----

    @Test
    @DisplayName("L3: bunga negatif ditolak dengan pesan yang benar")
    void constructor_bungaNegatif_ditolak() {
        // Arrange: bunga negatif sebagai data uji, data lain valid
        double bungaNegatif = -0.01;

        // Act: buat SavingsAccount dengan bunga negatif, hasilnya harus berupa exception
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> new SavingsAccount("005", "Eka", 100_000, bungaNegatif));

        // Assert: pesan exception sesuai
        assertEquals("Bunga tidak boleh negatif", ex.getMessage());
    }

    // ---- Latihan 5 ----

    @Test
    @DisplayName("L5: pajak bunga 20% diuji lewat variabel bertipe Taxable")
    void tax_pajakBungaDuaPuluhPersen() {
        // Arrange: SavingsAccount (saldo 100.000, bunga 5%) dipakai lewat tipe interface Taxable
        Taxable rekeningKenaPajak = savings;

        // Act: hitung pajak
        double pajak = rekeningKenaPajak.tax();

        // Assert: bunga 5.000 x 20% = 1.000
        assertEquals(1_000, pajak, 0.001);
    }

    @Test
    @DisplayName("L5: SavingsAccount adalah Taxable")
    void savingsAccount_adalahTaxable() {
        assertInstanceOf(Taxable.class, savings);
    }
}