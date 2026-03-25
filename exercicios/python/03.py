class ContaBancaria:
  def __init__(self, nome, numero_conta, saldo):
    self.nome = nome
    self.numero_conta = numero_conta
    self.saldo = saldo

  def saque(self, valor_saque):
    if self.saldo <= 0 or self.saldo < valor_saque:
      return "Saldo insuficiente!"
    self.saldo -= valor_saque
    return f"Saldo atual: {self.saldo}"
  
  def deposito(self, valor_deposito):
    self.saldo += valor_deposito
    return f"Saldo atual: {self.saldo}"
  
minhaConta = ContaBancaria("Maxwell Dantas", 12345, 1000)

novo_saldo_deposito = minhaConta.deposito(500)
print(novo_saldo_deposito)

novo_saldo_saque = minhaConta.saque(200)
print(novo_saldo_saque)

error = minhaConta.saque(2000)
print(error)