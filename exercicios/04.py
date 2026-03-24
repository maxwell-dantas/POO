class EntradaCinema:
    def __init__(self, dia, horario):
        self.dia = dia.lower()
        self.horario = horario
  
    def calcula_inteira(self):
        if self.dia == "quarta":
            return 8.00
            
        dias = ["segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domingo"]
        dia_semana = dias.index(self.dia)

        # segunda, terça ou quinta
        if dia_semana == 0 or dia_semana == 1 or dia_semana == 3:
            valor_base = 16.00
        # sexta, sábado ou domingo
        else:
            valor_base = 20.00
        
        # acréscimo noturno
        if self.horario >= 17 and self.horario <= 24:
            valor_base *= 1.5
          
        return valor_base

    def calcula_meia(self):
        if self.dia == "quarta":
            return 8.00
  
        return self.calcula_inteira() / 2
    

teste_1 = EntradaCinema("Segunda", 17)
print("Teste 01 - Segunda, 17h")
print(f"Valor entrada inteira: R${teste_1.calcula_inteira():.2f}")
print(f"Valor meia-entrada: R${teste_1.calcula_meia():.2f}")

print()

teste_2 = EntradaCinema("Segunda", 15)
print("Teste 02 - Segunda, 15h")
print(f"Valor da entrada inteira: R${teste_2.calcula_inteira():.2f}")
print(f"Valor da meia-entrada: R${teste_2.calcula_meia():.2f}")

print()

teste_3 = EntradaCinema("quarta", 18)
print("Teste 03 - Quarta, 18h")
print(f"Valor da entrada inteira/meia: R${teste_3.calcula_inteira():.2f}")
