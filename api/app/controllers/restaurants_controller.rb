class RestaurantsController < ApplicationController
  before_action :set_restaurant, only: :show

  def index
    @restaurants = Restaurant.all
    filter_by_query if params[:q]
    filter_by_city if params[:city]
    filter_by_category if params[:category]
  end

  def show
  end

  private

  def set_restaurant
    @restaurant = Restaurant.find_by(id: params[:id])
  end

  def filter_by_query
    @restaurants = @restaurants.ransack(name_or_description_cont: params[:q]).result
  end

  def filter_by_city
    @restaurants = @restaurants.where(city: params[:city])
  end

  def filter_by_category
    @restaurants = @restaurants.joins(:category).where(categories: { title: params[:category] })
  end
end