Feature: UPDATE QUERY

@insert
  Scenario: Yeni bir kullanıcı eklemek istiyorum ve eklenen verinin doğruluğunu test etmek istiyorum.

    * Database baglantisi olusturulur.
    * InsertQuery hazirlanir ve calistirilir.
    * Verinin kaydedildigi dogrulanir.
    * Database baglantisi sonlandirilir.
