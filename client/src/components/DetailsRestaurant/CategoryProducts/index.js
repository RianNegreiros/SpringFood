export default function CategoryProducts(props) {
  return (
    <>
      {props.title}
      {props.products.map((product, i) => { product.name })}
    </>
  )
}