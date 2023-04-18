Product.destroy_all
ProductCategory.destroy_all
Restaurant.destroy_all
Category.destroy_all

puts 'Creating Categories'

path_image = 'public/images/categories/mexican.jpg'
c = Category.create(id: 1, title: 'mexican')
c.image.attach(io: File.open(path_image), filename: 'mexican.jpg')

path_image = 'public/images/categories/italian.jpeg'
c = Category.create(id: 2, title: 'italian')
c.image.attach(io: File.open(path_image), filename: 'italian.jpeg')

path_image = 'public/images/categories/japonese.jpeg'
c = Category.create(id: 3, title: 'japanese')
c.image.attach(io: File.open(path_image), filename: 'japonese.jpeg')

path_image = 'public/images/categories/vegan.jpeg'
c = Category.create(id: 4, title: 'vegan')
c.image.attach(io: File.open(path_image), filename: 'vegan.jpeg')

path_image = 'public/images/categories/peruvian.jpg'
c = Category.create(id: 5, title: 'peruvian')
c.image.attach(io: File.open(path_image), filename: 'peruvian.jpg')


puts 'Creating Restaurants'

# Mexican Restaurants
path_image = 'public/images/restaurants/1.jpeg'
r = Restaurant.create!(
  name: 'Los Sombreros',
  description: 'Our mission has been to help people achieve their health and wellness goals. While we have changed over the years, our values have remained the same.',
  delivery_tax: 5.50,
  city: 'São Paulo', street: 'Bela terra',
  number: '1393', neighborhood: 'Mercês', category_id: 1
)
r.image.attach(io: File.open(path_image), filename: '1.jpg')
pc = ProductCategory.create!(title: 'Mexican dishes', restaurant: r)
prod = Product.create!(name: 'Nacho Guacamole', price: 19, description: 'Tortillas with Guacamole',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/nachosg.jpg'), filename: 'nachosg.jpg')
prod = Product.create!(name: 'Nacho', price: 19, description: 'Tortillas with corn', product_category: pc)
prod.image.attach(io: File.open('public/images/products/nachosg2.jpeg'), filename: 'nachosg2.jpeg')

# Curitiba
path_image = 'public/images/restaurants/1.jpeg'
r = Restaurant.create!(
  name: 'Los Sombreros - CWB',
  description: 'Our mission has been to help people achieve their health and wellness goals. While we have changed over the years, our values have remained the same.',
  delivery_tax: 5.50,
  city: 'Curitiba', street: 'Bela terra',
  number: '1393', neighborhood: 'Mercês', category_id: 1
)
r.image.attach(io: File.open(path_image), filename: '1.jpg')
pc = ProductCategory.create!(title: 'Mexican dishes', restaurant: r)
prod = Product.create!(name: 'Nacho Guacamole', price: 19, description: 'Tortillas with Guacamole',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/nachosg.jpg'), filename: 'nachosg.jpg')
prod = Product.create!(name: 'Nacho', price: 19, description: 'Tortillas with corn', product_category: pc)
prod.image.attach(io: File.open('public/images/products/nachosg2.jpeg'), filename: 'nachosg2.jpeg')

path_image = 'public/images/restaurants/2.jpeg'
r = Restaurant.create!(
  name: 'Ola Que Tal',
  description: 'To achieve and maintain this distinction in food and wine, service, ambience and ambiance, the restaurant earns a first-class reputation for gastronomy, gracious and informed hospitality, comfort and beauty that attracts new and repeat customers year after year.',
  delivery_tax: 5.50,
  city: 'São Paulo', street: 'Aminta de Barros',
  number: '659', neighborhood: 'Centro', category_id: 1
)
r.image.attach(io: File.open(path_image), filename: '2.jpg')
pc = ProductCategory.create!(title: 'Mexican dishes', restaurant: r)
prod = Product.create!(name: 'Burrito', price: 19, description: 'Tortillas with Guacamole',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/bt.jpg'), filename: 'bt.jpg')
prod = Product.create!(name: 'Quesadilha', price: 25, description: 'Cheese tortillas',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/quesa.jpeg'), filename: 'quesa.jpeg')

#Curitiba
path_image = 'public/images/restaurants/2.jpeg'
r = Restaurant.create!(
  name: 'Ola Que Tal - CWB',
  description: 'To achieve and maintain this distinction in food and wine, service, ambience and ambiance, the restaurant earns a first-class reputation for gastronomy, gracious and informed hospitality, comfort and beauty that attracts new and repeat customers year after year.',
  delivery_tax: 5.50,
  city: 'Curitiba', street: 'Aminta de Barros',
  number: '659', neighborhood: 'Centro', category_id: 1
)
r.image.attach(io: File.open(path_image), filename: '2.jpg')
pc = ProductCategory.create!(title: 'Mexican dishes', restaurant: r)
prod = Product.create!(name: 'Burrito', price: 19, description: 'Tortillas with Guacamole',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/bt.jpg'), filename: 'bt.jpg')
prod = Product.create!(name: 'Quesadilha', price: 25, description: 'Cheese tortillas',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/quesa.jpeg'), filename: 'quesa.jpeg')

# Italian Restaurants
path_image = 'public/images/restaurants/3.jpeg'
r = Restaurant.create!(
  name: 'Bravo',
  description: 'We are committed to using the best ingredients in our recipes. No food leaves our kitchen that we ourselves would not eat.',
  delivery_tax: 3.50,
  city: 'São Paulo', street: 'Rua via mar',
  number: '250', neighborhood: 'Centro', category_id: 2
)
r.image.attach(io: File.open(path_image), filename: '3.jpg')
pc = ProductCategory.create!(title: 'Portions', restaurant: r)
prod = Product.create!(name: 'Berinjela à parmegiana', price: 78, description: 'With rice and fries',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/berinjela.jpg'), filename: 'berinjela.jpg')
prod = Product.create!(name: 'Fritas', price: 35, description: 'bacon fries',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/fritas.jpg'), filename: 'fritas.jpg')

#Maceio
path_image = 'public/images/restaurants/3.jpeg'
r = Restaurant.create!(
  name: 'Bravo - Maceio',
  description: 'We are committed to using the best ingredients in our recipes. No food leaves our kitchen that we ourselves would not eat.',
  delivery_tax: 3.50,
  city: 'Maceio', street: 'Rua via mar',
  number: '250', neighborhood: 'Centro', category_id: 2
)
r.image.attach(io: File.open(path_image), filename: '3.jpg')
pc = ProductCategory.create!(title: 'Portions', restaurant: r)
prod = Product.create!(name: 'Berinjela à parmegiana', price: 78, description: 'With rice and fries',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/berinjela.jpg'), filename: 'berinjela.jpg')
prod = Product.create!(name: 'Fritas', price: 35, description: 'bacon fries',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/fritas.jpg'), filename: 'fritas.jpg')

path_image = 'public/images/restaurants/4.jpeg'
r = Restaurant.create!(
  name: 'La Pergoletti',
  description: 'Our mission is to establish beneficial business relationships with diverse suppliers who share our commitment to customer service, quality and competitive pricing.',
  delivery_tax: 6.70,
  city: 'São Paulo', street: 'Rua Joaquim Pinto',
  number: '929', neighborhood: 'Vila Gomes Cardim', category_id: 2
)
r.image.attach(io: File.open(path_image), filename: '4.jpg')
pc = ProductCategory.create!(title: 'Fogazzas (Individual)', restaurant: r)
prod = Product.create!(name: 'Fogazza Bacon', price: 12, description: 'Bacon, parmesan and mozzarella.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/fogazza.jpg'), filename: 'fogazza.jpg')
prod = Product.create!(name: 'Fogazza A moda da Casa', price: 12, description: 'Pepperoni, bacon, heart of palm and mozzarella.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/fogazza.jpg'), filename: 'fogazza.jpg')

# Japonese Restaurants
path_image = 'public/images/restaurants/5.jpeg'
r = Restaurant.create!(
  name: 'Sushi Eterno',
  description: 'We exist to ensure that every guest receives prompt, professional, friendly and courteous service.',
  delivery_tax: 7.50,
  city: 'São Paulo', street: 'Avenida Manoel Domingos Pinto',
  number: '507', neighborhood: 'Parque Anhangüera', category_id: 3
)
r.image.attach(io: File.open(path_image), filename: '5.jpg')
pc = ProductCategory.create!(title: 'Appetizer', restaurant: r)
prod = Product.create!(name: 'Temaki', price: 19.99, description: 'Rolled rice with seaweed in a cone shape',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/temaki.jpeg'), filename: 'temaki.jpeg')
prod = Product.create!(name: 'Sashimi', price: 30.90, description: 'Sliced raw fish, salmon, tuna and capuchin fish',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/sashimi.jpg'), filename: 'sashimi.jpg')

#Maceio
path_image = 'public/images/restaurants/5.jpeg'
r = Restaurant.create!(
  name: 'Sushi Eterno - Maceio',
  description: 'We exist to ensure that every guest receives prompt, professional, friendly and courteous service.',
  delivery_tax: 7.50,
  city: 'Maceio', street: 'Avenida do mar',
  number: '2344', neighborhood: 'Belo mar', category_id: 3
)
r.image.attach(io: File.open(path_image), filename: '5.jpg')
pc = ProductCategory.create!(title: 'Appetizer', restaurant: r)
prod = Product.create!(name: 'Temaki', price: 19.99, description: 'Rolled rice with seaweed in a cone shape',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/temaki.jpeg'), filename: 'temaki.jpeg')
prod = Product.create!(name: 'Sashimi', price: 30.90, description: 'Sliced raw fish, salmon, tuna and capuchin fish',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/sashimi.jpg'), filename: 'sashimi.jpg')

path_image = 'public/images/restaurants/6.jpeg'
r = Restaurant.create!(
  name: 'Okuyamah',
  description: 'Renowned restaurant, winner for 5 times as the best Japanese restaurant in São Paulo.',
  delivery_tax: 8.30,
  city: 'São Paulo', street: 'Rua Francisco Artassio',
  number: '134', neighborhood: 'Jardim das Laranjeiras', category_id: 3
)
r.image.attach(io: File.open(path_image), filename: '6.jpg')
pc = ProductCategory.create!(title: 'Appetizer', restaurant: r)
prod = Product.create!(name: 'Hossomaki 16 pieces', price: 20.90, description: 'Thinly rolled with seaweed on the outside.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/hosomaki.jpg'), filename: 'hosomaki.jpg')
prod = Product.create!(name: 'Hot roll - 10 pieces', price: 12, description: '10 pieces.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/hot-holl.jpg'), filename: 'hot-holl.jpg')

#Maceio
path_image = 'public/images/restaurants/6.jpeg'
r = Restaurant.create!(
  name: 'Okuyamah - Maceio',
  description: 'Renowned restaurant, winner for 5 times as the best Japanese restaurant in São Paulo.',
  delivery_tax: 8.30,
  city: 'Maceio', street: 'Rua Francisco Artassio',
  number: '134', neighborhood: 'Jardim das Laranjeiras', category_id: 3
)
r.image.attach(io: File.open(path_image), filename: '6.jpg')
pc = ProductCategory.create!(title: 'Appetizer', restaurant: r)
prod = Product.create!(name: 'Hossomaki 16 pieces', price: 20.90, description: 'Thinly rolled with seaweed on the outside.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/hosomaki.jpg'), filename: 'hosomaki.jpg')
prod = Product.create!(name: 'Hot roll - 10 pieces', price: 12, description: '10 pieces.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/hot-holl.jpg'), filename: 'hot-holl.jpg')

# Vegan Restaurants
path_image = 'public/images/restaurants/7.jpeg'
r = Restaurant.create!(
  name: 'Club Life',
  description: 'OUR SPECIALITY. high-quality plant-based dishes, with whole-food, gluten-free and lactose-free options.',
  delivery_tax: 5.70,
  city: 'São Paulo', street: 'Alameda dos Uapês',
  number: '933', neighborhood: 'Planalto Paulista', category_id: 4
)
r.image.attach(io: File.open(path_image), filename: '7.jpg')
pc = ProductCategory.create!(title: 'Salads, sauces and wraps', restaurant: r)
prod = Product.create!(name: 'Coleslaw', price: 8.99, description: 'Red cabbage, kale, carrot, onion, chestnut mayonnaise and xylitol',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/coleslaw.jpg'), filename: 'coleslaw.jpg')
prod = Product.create!(name: 'Side salad', price: 9.90, description: 'Mix of leaves with grated carrot, sweet tomato and sunflower seed.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/side-salad.jpeg'), filename: 'side-salad.jpeg')

path_image = 'public/images/restaurants/8.jpeg'
r = Restaurant.create!(
  name: 'Casa Natural',
  description: 'Since 1981, we have been offering ovo-lacto-vegetarian meals that are light, healthy, balanced and, above all, tasty, seeking to combine taste, quality of life and well-being for our customers.',
  delivery_tax: 8.30,
  city: 'São Paulo', street: 'Rua Natal',
  number: '938', neighborhood: 'Cantinho do Céu', category_id: 4
)
r.image.attach(io: File.open(path_image), filename: '8.jpg')
pc = ProductCategory.create!(title: 'Salads, sauces and wraps', restaurant: r)
prod = Product.create!(name: 'Salada de quinoa', price: 20.90, description: 'Iceberg lettuce, purple lettuce, frisee, cooked quinoa, carrot, tomato, dried apricot, raw almond.',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/salada-de-quinoa.jpg'), filename: 'salada-de-quinoa.jpg')
prod = Product.create!(name: 'Coleslaw', price: 11, description: 'Red cabbage, kale, carrot, onion, chestnut mayonnaise and xylitol',  product_category: pc)
prod.image.attach(io: File.open('public/images/products/coleslaw2.jpeg'), filename: 'coleslaw2.jpeg')