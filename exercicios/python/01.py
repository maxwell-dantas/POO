class area_circulo: # define o molde para o cálculo da área de um círculo
  def __init__(self): # inicia as propriedades da classe 
    self.raio = 0 # propriedade raio
  def calcula_area(self): # método para calcular a área do círculo
    return self.raio ** 2 * 3.14 # raio ^ 2 * pi
  
x = area_circulo() # materialização do objeto, no momento, x está servindo como referência ao objeto.
x.raio = 3 
print(x.calcula_area()) 
  