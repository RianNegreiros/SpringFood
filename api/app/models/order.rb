class Order < ApplicationRecord
  belongs_to :restaurant

  has_many :order_products

  validates :name, :phone_number, :total_value, :city, :neighborhood, :street, :number, presence: true
end
